import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

public class RateLimitterInterview {
    public static void main(String[] args) {
        final Map<String,Metadata> map = new HashMap<>();
        String username = "ajay";
        isUserAllowed(map,username);

    }

    public static boolean isUserAllowed(Map<String,Metadata> userRequest, String username){
        //first time login
        if(userRequest.get(username)== null){
            Metadata userDetails = new Metadata();
            userDetails.setCount(1);
            userDetails.setInitialTime(System.currentTimeMillis());
            userRequest.put(username,userDetails);
            return true;
        }
        else{
            Metadata metadata = userRequest.get(username);
            Long initialTime = metadata.getInitialTime();
            int count = metadata.getCount();
            Long consumedTimed = (System.currentTimeMillis() - initialTime)/1000;
            if (count <= 5 && consumedTimed <= 60) {
                return true;
            }
            metadata = userRequest.get(username);
            consumedTimed = (System.currentTimeMillis() - initialTime)/1000;
            if(consumedTimed > 60){
                metadata.setCount(0);
                metadata.setInitialTime(System.currentTimeMillis());
                return true;
            }
        }
        return false;
    }



    static class Metadata{
        int count;
        Long intialTime;

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public Long getInitialTime() {
            return intialTime;
        }

        public void setInitialTime(Long intialTime) {
            this.intialTime = intialTime;
        }
    }
}
