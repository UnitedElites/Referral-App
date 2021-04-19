package com.example.referal_app_version2;

public class Appointment {

        private String email;
        private String title;
        private String appoint_date;
        private String day_time;
        private String appoint_detail;
        private String image_url;

        Appointment(){

        }

        Appointment(String email, String title, String appoint_date, String day_time, String appoint_detail,String image_url) {
            this.email = email;
            this.title = title;
            this.appoint_date = appoint_date;
            this.day_time = day_time;
            this.appoint_detail = appoint_detail;
            this.image_url = image_url;

        }


        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getEmail() {
            return email;
        }

        public void setAppoint_date(String appoint_date) {
            this.appoint_date = appoint_date;
        }

        public String getAppoint_date() {
            return appoint_date;
        }
        public void setDay_time(String day_time) {
            this.day_time = day_time;
        }

        public String getDay_time() {
            return day_time;
        }

        public void setAppoint_detail(String appoint_detail) {
            this.appoint_detail = appoint_detail;
        }

        public String getAppoint_detail() {
            return appoint_detail;
        }

        public String getImage_url() {
            return image_url;
        }

        public void setImage_url(String image_url) {
            this.image_url = image_url;
        }



        @Override
        public String toString() {
            return "Appointment{" +
                    "Title ='" + title + '\'' +
                    ", appint_date='" + appoint_date + '\'' +
                    ", email='" + email + '\'' +
                    ", day_time='" + day_time + '\'' +
                    '}';
        }
}
