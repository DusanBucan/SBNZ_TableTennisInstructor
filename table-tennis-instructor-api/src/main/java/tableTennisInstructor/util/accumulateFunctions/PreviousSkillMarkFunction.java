package tableTennisInstructor.util.accumulateFunctions;

import org.kie.api.runtime.rule.AccumulateFunction;
import tableTennisInstructor.model.drools.facts.training.TrainingExecution;
import tableTennisInstructor.model.drools.facts.training.TrainingMark;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.Serializable;

public class PreviousSkillMarkFunction implements AccumulateFunction {

    @Override
    public void writeExternal(ObjectOutput objectOutput) throws IOException {
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException, ClassNotFoundException {
    }

    private static class MyContext implements Serializable {
        public double count = 0;
        public double total = 0;
    }


    @Override
    public Serializable createContext() {
        return new MyContext();
    }

    @Override
    public void init(Serializable serializable) throws Exception {
        MyContext myContext = (MyContext) serializable;
        myContext.count = 0;
        myContext.total = 0;
    }

    @Override
    public void accumulate(Serializable serializable, Object o) {
        TrainingExecution trainingExecution = (TrainingExecution) o;
        MyContext myContext = (MyContext) serializable;
        myContext.count += 1;
        switch (trainingExecution.getTrainingMark()){
            case EXCELLENT:
                myContext.total += 5;
                break;
            case GOOD:
                myContext.total += 3;
                break;
            default:
                myContext.total += 1;
                break;
        }
    }

    @Override
    public void reverse(Serializable serializable, Object o) throws Exception {
    }

    @Override
    public Object getResult(Serializable serializable) throws Exception {
        MyContext myContext = (MyContext) serializable;
        return  myContext.total / myContext.count;
    }

    @Override
    public boolean supportsReverse() {
        return false;
    }

    @Override
    public Class<?> getResultType() {
        return double.class;
    }

}
