package cannibalsAndMissionaries;

import java.util.LinkedHashSet;
import java.util.Set;

public class State {

    int direction;
    int cannibalsLeft;
    int cannibalsRight;
    int missionariesLeft;
    int missionariesRight;

    public State(int direction, int cannibalsLeft, int cannibalsRight, int missionariesLeft, int missionariesRight) {
        this.direction = direction;
        this.cannibalsLeft = cannibalsLeft;
        this.cannibalsRight = cannibalsRight;
        this.missionariesLeft = missionariesLeft;
        this.missionariesRight = missionariesRight;
    }

    public Set<State> neighborStates() {
        Set<State> result = new LinkedHashSet<State>();

        if (direction == 0) {

            if (cannibalsLeft >= 1) {
                if ((cannibalsLeft - 1 <= missionariesLeft ||  missionariesLeft == 0) &&
                        ((cannibalsRight + 1 <= missionariesRight) || missionariesRight == 0)) {
                    State aux = new State(1, cannibalsLeft - 1, cannibalsRight + 1, missionariesLeft, missionariesRight);
                    result.add(aux);
                }
            }

            if (missionariesLeft >= 1) {
                if ((cannibalsLeft <= missionariesLeft - 1 ||  missionariesLeft - 1 == 0) &&
                        ((cannibalsRight <= missionariesRight + 1) || missionariesRight + 1 == 0)) {
                    State aux = new State(1, cannibalsLeft, cannibalsRight, missionariesLeft - 1, missionariesRight + 1);
                    result.add(aux);
                }
            }

            if (cannibalsLeft >= 2) {
                 if ((cannibalsLeft - 2 <= missionariesLeft ||  missionariesLeft == 0) &&
                        ((cannibalsRight + 2 <= missionariesRight) || missionariesRight == 0)) {
                    State aux = new State(1, cannibalsLeft - 2, cannibalsRight + 2, missionariesLeft, missionariesRight);
                    result.add(aux);
                }
            }

            if (missionariesLeft >= 2) {
                if ((cannibalsLeft <= missionariesLeft - 2 ||  missionariesLeft - 2 == 0) &&
                        ((cannibalsRight <= missionariesRight + 2) || missionariesRight + 2 == 0)) {
                    State aux = new State(1, cannibalsLeft, cannibalsRight, missionariesLeft - 2, missionariesRight + 2);
                    result.add(aux);
                }
            }

            if (missionariesLeft >= 1 && cannibalsLeft >= 1) {
                if ((cannibalsLeft - 1 <= missionariesLeft -1 ||  missionariesLeft - 1 == 0) &&
                        ((cannibalsRight + 1 <= missionariesRight + 1) || missionariesRight + 1 == 0)) {
                    State aux = new State(1, cannibalsLeft - 1, cannibalsRight + 1, missionariesLeft - 1, missionariesRight + 1);
                    result.add(aux);
                }
            }


        } else  {

            if (cannibalsRight >= 1) {
                if ((cannibalsLeft + 1 <= missionariesLeft ||  missionariesLeft == 0) &&
                        ((cannibalsRight - 1 <= missionariesRight) || missionariesRight == 0)) {
                    State aux = new State(0, cannibalsLeft + 1, cannibalsRight - 1, missionariesLeft, missionariesRight);
                    result.add(aux);
                }

            }

            if (missionariesRight >= 1) {
                if ((cannibalsLeft <= missionariesLeft + 1 ||  missionariesLeft + 1 == 0) &&
                        ((cannibalsRight <= missionariesRight - 1) || missionariesRight - 1 == 0)) {
                    State aux = new State(0, cannibalsLeft, cannibalsRight, missionariesLeft + 1, missionariesRight - 1);
                    result.add(aux);
                }

            }
            if (cannibalsRight >= 2) {
              if ((cannibalsLeft + 2 <= missionariesLeft ||  missionariesLeft == 0) &&
                        ((cannibalsRight - 2 <= missionariesRight) || missionariesRight == 0)) {
                    State aux = new State(0, cannibalsLeft + 2, cannibalsRight - 2, missionariesLeft, missionariesRight);
                    result.add(aux);
                }

            }

            if (missionariesRight >= 2) {
                if ((cannibalsLeft <= missionariesLeft + 2 ||  missionariesLeft + 2 == 0) &&
                        ((cannibalsRight <= missionariesRight - 2) || missionariesRight - 2 == 0)) {
                    State aux = new State(0, cannibalsLeft, cannibalsRight, missionariesLeft + 2, missionariesRight -2);
                    result.add(aux);
                }

            }

            if (missionariesRight >= 1 && cannibalsRight >= 1) {
                if ((cannibalsLeft + 1 <= missionariesLeft + 1 ||  missionariesLeft + 1 == 0) &&
                        ((cannibalsRight - 1 <= missionariesRight - 1) || missionariesRight - 1 == 0)) {
                    State aux = new State(0, cannibalsLeft + 1, cannibalsRight - 1, missionariesLeft + 1, missionariesRight - 1);
                    result.add(aux);
                }
            }
        }
        return result; 
    }

    public boolean winTest(){
        if(cannibalsRight == 3 && missionariesRight == 3){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public String toString() {
        return "Main{" +
                "direction=" + direction +
                ", cannibalsLeft=" + cannibalsLeft +
                ", missionariesLeft=" + missionariesLeft +
                ", cannibalsRight=" + cannibalsRight +
                ", missionariesRight=" + missionariesRight +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        State state = (State) o;

        if (direction != state.direction) return false;
        if (cannibalsLeft != state.cannibalsLeft) return false;
        if (cannibalsRight != state.cannibalsRight) return false;
        if (missionariesLeft != state.missionariesLeft) return false;
        return missionariesRight == state.missionariesRight;
    }

    @Override
    public int hashCode() {
        int result = direction;
        result = 31 * result + cannibalsLeft;
        result = 31 * result + cannibalsRight;
        result = 31 * result + missionariesLeft;
        result = 31 * result + missionariesRight;
        return result;
    }
}
