public class Smartphone {
    //(name, model, year, ram, rom, displaySize, battery, etc)

    private String name="iPhone 12";
    private String model="A2172";
    private int year=2020;
    private String ram="4 GB";
    private String rom ="64 GB";
    private double displaySize=6.1;
    private int battery=2815;

    public Smartphone() {

    }





    public int getBattery() {
        return battery;
    }

    public int getYear() {
        return year;
    }

    public String getModel() {
        return model;
    }

    public String getRam() {
        return ram;
    }
    public String getRom() {
        return rom;
    }

    public String getName(){
        return name;
    }

    public double getDisplaySize() {
        return displaySize;
    }

    public boolean isNewRelease(){
        return year > 2024;
    }

    public boolean hasLargeDisplay(){
        return displaySize > 6.5;
    }

    public  boolean bigBattery(){
        return battery > 4000;
    }


    public String smartPhoneRating(String ram, String rom, int battery) {
        if (ram.equals("4 GB") && rom.equals("64 GB") && battery == 2815) {
            return "Bad phone for buy";
        }
        return "Good phone for buy";
    }
    public String isNormalDisplaySizeForUse(double displaySize){
        if (displaySize>=6.1 && displaySize<7.6){
            return "Good display size";
        }

        return "Bad display size";
    }
}
