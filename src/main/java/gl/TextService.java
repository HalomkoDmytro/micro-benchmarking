package gl;

import java.util.List;

public class TextService {

    public String staticText() {
        return "Some static text";
    }

    public String variable(String variable) {
        return variable;
    }

    public String exception(String text) throws RuntimeException {
        throw new CustomException();
    }

    public String exceptionCatch(String text) throws RuntimeException {
        try {
            throw new CustomException();
        } catch (CustomException ex) {
        }
        return text;
    }

    public String exceptionCatchWithStackTrace(String text) throws RuntimeException {
        try {
            throw new CustomException();
        } catch (CustomException ex) {
            ex.printStackTrace();
        }
        return text;
    }

    public void forLoop(List<Integer> list) {
        for(Integer i : list) {
        }
    }

    public void streamLoop(List<Integer> list) {
        list.stream().forEach(x -> {});
    }
}