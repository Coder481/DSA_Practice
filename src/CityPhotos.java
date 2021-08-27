import java.util.*;

/**
 * Print all the image's data by replacing the file name with
 * the ordered index of that image.
 *
 * Read more about the problem here ->
 *              https://docs.google.com/document/d/1FH65QiuUcNU_trbbcImYHevL3xOXStRmQApxxzyulQ8/edit?usp=drivesdk
 */
public class CityPhotos {

    public static void main(String[] args) {

        String s = "A,Udaipur,10/05 14:00\n"+
                "A1,Jaipur,20/06 12:00\n"+
                "A2,Mumbai,25/07 09:00\n"+
                "A3,Mumbai,25/07 07:15\n"+
                "A4,Jaipur,20/06 16:00\n"+
                "A4,Udaipur,10/05 10:00\n"+
                "A1,Jaipur,20/06 12:05\n"+
                "A2,Mumbai,25/07 09:05\n"+
                "A3,Mumbai,25/07 07:25\n"+
                "A6,Jaipur,20/06 16:05\n"+
                "A8,Udaipur,10/05 10:05\n"+
                "A5,Udaipur,10/05 10:15\n"+
                "A9,Udaipur,10/05 10:25\n"+
                "A11,Udaipur,10/05 10:35\n"+
                "A45,Udaipur,10/05 10:55\n"+
                "A23,Udaipur,10/05 10:45\n"+
                "A32,Udaipur,10/05 10:40\n"+
                "A09,Udaipur,10/05 10:30\n"+
                "A10,Udaipur,10/05 10:27\n";

        String[] strArr = s.split("\n");

        HashMap<String, List<String>> cityWithTimeMap = new HashMap<>();

        // Saving the sorted list of time in HashMap
        for (String imgData : strArr){

            String[] imgDataArr = imgData.split(",");
            String cityName = imgDataArr[1];
            String time = imgDataArr[2];

            if (cityWithTimeMap.containsKey(cityName)){
                cityWithTimeMap.get(cityName).add(time);
            }
            else {
                List<String> nl = new ArrayList<>();
                nl.add(time);
                cityWithTimeMap.put(cityName,nl);
            }

            cityWithTimeMap.get(cityName).sort(String::compareTo);
        }


        // Storing output data in StringBuilder
        StringBuilder result = new StringBuilder();
        for (String imgData : strArr){

            String[] imgDataArr = imgData.split(",");

            String fileName = imgDataArr[0];
            String cityName = imgDataArr[1];
            String time = imgDataArr[2];

            List<String> timeList = cityWithTimeMap.get(cityName);
            int position =  timeList.indexOf(time) + 1;

            int numberOfDigits = (timeList.size()+"").length();
            String format = "%0"+numberOfDigits+"d";
            String posStr = String.format(format,position);

            result.append(fileName)
                    .append("\t\t")
                    .append(cityName).append(posStr).append(".jpg")
                    .append("\t\t")
                    .append(time)
                    .append("\n");

        }

        printLn(result.toString());

    }

    private static void printLn(String s){
        System.out.println(s);
    }
}
