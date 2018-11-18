import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeListOfIntervals {


    public class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }

        @Override
        public String toString() {
            return "[" + start + " , " + end + "]";
        }
    }


    public List<Interval> createInterval() {
        List<Interval> intervals = Arrays.asList(new Interval(1, 3),
                new Interval(2, 6),
                new Interval(8, 10),
                new Interval(15, 18)
        );

        System.out.println("Input: " + intervals);
        return intervals;
    }


    public static void main(String[] args) {

        MergeListOfIntervals mergeListOfIntervals = new MergeListOfIntervals();
        System.out.println("Output: " + mergeListOfIntervals.solution(mergeListOfIntervals.createInterval()));

    }


    public List<Interval> solution(List<Interval> inputList) {
        List<Interval> output = new ArrayList<>();
        if (inputList == null || inputList.size() == 0) {
            return output;
        }

        inputList.sort((o1, o2) -> {
            if (o1.start != o2.start) {
                return o1.start - o2.start;
            } else {
                return o1.end - o2.end;
            }
        });

        Interval previous = inputList.get(0);
        for (int i = 1; i < inputList.size(); i++) {
            Interval current = inputList.get(i);
            if (previous.end > current.start) {
                Interval merged = new Interval(previous.start, Math.max(previous.end, current.end));
                output.add(merged);
                previous = merged;
            } else {
                output.add(current);
                previous = current;
            }
        }

        return output;
    }


}
