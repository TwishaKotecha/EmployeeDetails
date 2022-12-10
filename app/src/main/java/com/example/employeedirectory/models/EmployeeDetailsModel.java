package com.example.employeedirectory.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class EmployeeDetailsModel {

    @SerializedName("employees")
    private List<Employees> employees;

    public List<Employees> getEmployees() {
        return employees;
    }

    public static class Employees {
        @SerializedName("uuid")
        private String uuid;

        @SerializedName("full_name")
        private String full_name;

        @SerializedName("phone_number")
        private String phone_number;

        @SerializedName("email_address")
        private String email_address;

        @SerializedName("biography")
        private String biography;

        @SerializedName("photo_url_small")
        private String photo_url_small;

        @SerializedName("photo_url_large")
        private String photo_url_large;

        @SerializedName("team")
        private String team;

        @SerializedName("employee_type")
        private String employee_type;

        public Employees(String uuid, String full_name, String phone_number, String email_address, String biography, String photo_url_small, String photo_url_large, String team, String employee_type) {
            this.uuid = uuid;
            this.full_name = full_name;
            this.phone_number = phone_number;
            this.email_address = email_address;
            this.biography = biography;
            this.photo_url_small = photo_url_small;
            this.photo_url_large = photo_url_large;
            this.team = team;
            this.employee_type = employee_type;
        }


        public String getUuid() {
            return uuid;
        }

        public void setUuid(String uuid) {
            this.uuid = uuid;
        }

        public String getFull_name() {
            return full_name;
        }

        public void setFull_name(String full_name) {
            this.full_name = full_name;
        }

        public String getPhone_number() {
            return phone_number;
        }

        public void setPhone_number(String phone_number) {
            this.phone_number = phone_number;
        }

        public String getEmail_address() {
            return email_address;
        }

        public void setEmail_address(String email_address) {
            this.email_address = email_address;
        }

        public String getBiography() {
            return biography;
        }

        public void setBiography(String biography) {
            this.biography = biography;
        }

        public String getPhoto_url_small() {
            return photo_url_small;
        }

        public void setPhoto_url_small(String photo_url_small) {
            this.photo_url_small = photo_url_small;
        }

        public String getPhoto_url_large() {
            return photo_url_large;
        }

        public void setPhoto_url_large(String photo_url_large) {
            this.photo_url_large = photo_url_large;
        }

        public String getTeam() {
            return team;
        }

        public void setTeam(String team) {
            this.team = team;
        }

        public String getEmployee_type() {
            return employee_type;
        }

        public void setEmployee_type(String employee_type) {
            this.employee_type = employee_type;
        }
    }
}
