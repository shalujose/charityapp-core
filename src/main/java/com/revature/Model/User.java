package com.revature.model;

public class User {
		@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", gender=" + gender + ", age=" + age + ", phone=" + phone
				+ ", email=" + email + ", password=" + password + "]";
	}
		private int id;
		private String name;
		private String gender;
		private int age;
		private long phone;
		private String email;
		private String password;
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getGender() {
			return gender;
		}
		public void setGender(String gender) {
			this.gender = gender;
		}
		public int getAge() {
			return age;
		}
		public void setAge(int age) {
			this.age = age;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email=email;
		}
		public long getPhone() {
			return phone;
		}
		public void setPhone(long phone) {
			this.phone = phone;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password=password;
		}
		
}
