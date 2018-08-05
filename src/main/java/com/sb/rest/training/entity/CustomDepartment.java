package com.sb.rest.training.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CustomDepartment {
		
		@Id
		@Column(name="id")
		private long id;
	
		@Column(name="name")
		private String name;

		public CustomDepartment(long id, String name) {
			setId(id);
			setName(name);
		}

		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
}
