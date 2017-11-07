package domains.arithmetic;

import framework.problem.Mover;
import framework.problem.State;
/**
 * 
 * @author Riley Brust
 */
public class ArithmeticMover extends Mover {

        public static final String ADD= "Add 3";
        public static final String SUB = "Subtract 5";
        public static final String DIVIDE = "Divide by 2";
        public static final String MULT = "Multiply by 2";
    
        public ArithmeticMover() {
            super.addMove(ADD, s -> tryAdd(s));
            super.addMove(SUB, s -> trySub(s));
            super.addMove(DIVIDE, s -> tryDiv(s));
            super.addMove(MULT, s -> tryMult(s));
        }

        private State tryAdd(State state) {
     
            String one = state.toString();
            String num = one.substring(14, one.length());
            int inte = Integer.parseInt(num);
            return new ArithmeticState(inte +3);
  
        }

        private State trySub(State state) {
            String one = state.toString();
            String num = one.substring(14, one.length());
            int inte = Integer.parseInt(num);
            return new ArithmeticState(inte -5);
        }

        private State tryDiv(State state) {
            String one = state.toString();
            String num = one.substring(14, one.length());
            int inte = Integer.parseInt(num);
            return new ArithmeticState(inte / 2);
        }

        private State tryMult(State state) {
            String one = state.toString();
            String num = one.substring(14, one.length());
            int inte = Integer.parseInt(num);
            return new ArithmeticState(inte * 2);
        }

        private State illegalMove(State state) {
            return null;
        }
    }