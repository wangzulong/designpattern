package com.wangzulong.designpattern.chainofresponsibility;

/**
 * @author wangzulong
 * @version 1.0
 * @date 2020/7/18 23:48
 */
public class ChainOfResponsibilityTest {
    public static void main(String[] args) {
        Request request = new Request.RequestBuilder().loggedon(false).frequentOk(false).build();
        RequestFrequentHandler requestFrequentHandler = new RequestFrequentHandler(new LoggingHandler(null));
        if (requestFrequentHandler.process(request)) {
            System.out.println("正常业务处理");
        } else {
            System.out.println("访问异常");
        }
    }
}

class Request {
    private boolean loggedon;
    private boolean frequentOk;
    private boolean isPermits;
    private boolean containsSensitiveWords;
    private String requestBody;

    public Request(boolean loggedon, boolean frequentOk, boolean isPermits, boolean containsSensitiveWords) {
        this.loggedon = loggedon;
        this.frequentOk = frequentOk;
        this.isPermits = isPermits;
        this.containsSensitiveWords = containsSensitiveWords;
    }

    static class RequestBuilder {
        private boolean loggedon;
        private boolean frequentOk;
        private boolean isPermits;
        private boolean containsSensitiveWords;

        RequestBuilder loggedon(boolean loggedon) {
            this.loggedon = loggedon;
            return this;
        }

        RequestBuilder frequentOk(boolean frequentOk) {
            this.frequentOk = frequentOk;
            return this;
        }

        RequestBuilder isPermits(boolean isPermits) {
            this.isPermits = isPermits;
            return this;
        }

        RequestBuilder containsSensitiveWords(boolean containsSensitiveWords) {
            this.containsSensitiveWords = containsSensitiveWords;
            return this;
        }

        public Request build() {
            Request request = new Request(loggedon, frequentOk, isPermits, containsSensitiveWords);
            return request;
        }
    }

    public boolean isLoggedon() {
        return loggedon;
    }

    public boolean isFrequentOk() {
        return frequentOk;
    }

    public boolean isPermits() {
        return isPermits;
    }

    public boolean isContainsSensitiveWords() {
        return containsSensitiveWords;
    }
}


abstract class Handler {
    Handler next;

    public Handler(Handler next) {
        this.next = next;
    }

    public Handler getNext() {
        return next;
    }

    public void setNext(Handler next) {
        this.next = next;
    }

    abstract boolean process(Request request);
}

class RequestFrequentHandler extends Handler {

    public RequestFrequentHandler(Handler next) {
        super(next);
    }

    @Override
    boolean process(Request request) {
        System.out.println("访问频率控制。");
        if (request.isFrequentOk()) {
            Handler next = getNext();
            if (null == next) {
                return true;
            }

            if (!next.process(request)) {
                return false;
            } else {
                return true;
            }
        }
        return false;
    }
}

class LoggingHandler extends Handler {

    public LoggingHandler(Handler next) {
        super(next);
    }

    @Override
    boolean process(Request request) {
        System.out.println("登录验证。");
        if (request.isLoggedon()) {
            Handler next = getNext();
            if (null == next) {
                return true;
            }

            if (!next.process(request)) {
                return false;
            } else {
                return true;
            }
        }
        return false;
    }
}