package domains.arithmetic;

import framework.problem.State;
import java.util.stream.Stream;
/**
 * 
 * @author Riley Brust
 */
public class ArithmeticState implements State {
    
        public ArithmeticState(int contents) {
            this.contents = contents;
        }

        @Override
        public boolean equals(Object other) {
            ArithmeticState otherArithmetic = (ArithmeticState) other;
            return this.contents == otherArithmetic.contents;
        }

        @Override
        public String toString() {
          String str = "The value is: " + contents;
          return str;
        }
       


        private final int contents;

    }