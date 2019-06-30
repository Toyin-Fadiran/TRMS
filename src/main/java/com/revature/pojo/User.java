package com.revature.pojo;

public class User {
	
	private Integer userId;
	
	private String username;
	
	public User(Integer userId, String username, String password, String fullname, String title, Integer reportsto) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.fullname = fullname;
		this.title = title;
		this.reportsto = reportsto;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	private String password;
		
		private String fullname;
		
		private String title;
		
		private Integer reportsto;
		
		public User(String username, String password, String fullname, String title, Integer reportsto) {
			super();
			this.username = username;
			this.password = password;
			this.fullname = fullname;
			this.title = title;
			this.reportsto = reportsto;
		}

		public User(String username, String password) {
			super();
			this.username = username;
			this.password = password;
		//	this.fullname = fullname;
		}
		
		public User() {
			super();
			// TODO Auto-generated constructor stub
		}

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getPassword() {
			return password;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public Integer getReportsto() {
			return reportsto;
		}

		public void setReportsto(Integer reportsto) {
			this.reportsto = reportsto;
		}

	

		public void setPassword(String password) {
			this.password = password;
		}

		public String getFullname() {
			return fullname;
		}

		public void setFullname(String fullname) {
			this.fullname = fullname;
		}		
		
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((fullname == null) ? 0 : fullname.hashCode());
			result = prime * result + ((password == null) ? 0 : password.hashCode());
			result = prime * result + ((reportsto == null) ? 0 : reportsto.hashCode());
			result = prime * result + ((title == null) ? 0 : title.hashCode());
			result = prime * result + ((userId == null) ? 0 : userId.hashCode());
			result = prime * result + ((username == null) ? 0 : username.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			User other = (User) obj;
			if (fullname == null) {
				if (other.fullname != null)
					return false;
			} else if (!fullname.equals(other.fullname))
				return false;
			if (password == null) {
				if (other.password != null)
					return false;
			} else if (!password.equals(other.password))
				return false;
			if (reportsto == null) {
				if (other.reportsto != null)
					return false;
			} else if (!reportsto.equals(other.reportsto))
				return false;
			if (title == null) {
				if (other.title != null)
					return false;
			} else if (!title.equals(other.title))
				return false;
			if (userId == null) {
				if (other.userId != null)
					return false;
			} else if (!userId.equals(other.userId))
				return false;
			if (username == null) {
				if (other.username != null)
					return false;
			} else if (!username.equals(other.username))
				return false;
			return true;
		}

		@Override
		public String toString() {
			return "User [userId=" + userId + ", username=" + username + ", password=" + password + ", fullname="
					+ fullname + ", title=" + title + ", reportsto=" + reportsto + "]";
		}

}
