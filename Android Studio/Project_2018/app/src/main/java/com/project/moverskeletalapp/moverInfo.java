
package com.project.moverskeletalapp;

public class moverInfo {

    private String fName;
    private String lName;
    private String license;
    private String VehReg;
    private String vehicleType;
    private String phoneNumber;

    public moverInfo(){

    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public String getVehReg() {
        return VehReg;
    }

    public void setVehReg(String vehReg) {
        VehReg = vehReg;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }
}
