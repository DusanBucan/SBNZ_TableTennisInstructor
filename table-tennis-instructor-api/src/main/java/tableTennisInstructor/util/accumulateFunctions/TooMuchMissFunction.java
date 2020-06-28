package tableTennisInstructor.util.accumulateFunctions;

import org.kie.api.runtime.rule.AccumulateFunction;
import tableTennisInstructor.model.drools.events.SkillExecutionEvent;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.Serializable;

public class TooMuchMissFunction implements AccumulateFunction {

    private static class MyContext implements Serializable {
        public double missed = 0;
        public double total = 0;
    }


    @Override
    public Serializable createContext() {
        return new MyContext();
    }

    @Override
    public void init(Serializable serializable) throws Exception {
        MyContext myContext = (MyContext) serializable;
        myContext.missed = 0;
        myContext.total = 0;
    }

    @Override
    public void accumulate(Serializable serializable, Object o) {
        SkillExecutionEvent executionEvent = (SkillExecutionEvent) o;
        MyContext myContext = (MyContext) serializable;
        myContext.total += 1;
        if(!executionEvent.getResult()) {
            myContext.missed += 1;
        }
    }

    @Override
    public void reverse(Serializable serializable, Object o) throws Exception {
    }

    @Override
    public Object getResult(Serializable serializable) throws Exception {
        MyContext myContext = (MyContext) serializable;
        return myContext.missed / myContext.total;
    }

    @Override
    public boolean supportsReverse() {
        return false;
    }

    @Override
    public Class<?> getResultType() {
        return double.class;
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput) throws IOException {

    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException, ClassNotFoundException {

    }
}
