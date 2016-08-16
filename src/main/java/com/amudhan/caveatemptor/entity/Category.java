package com.amudhan.caveatemptor.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.amudhan.caveatemptor.constant.CategoryQueries;
@NamedQueries({
	@NamedQuery(name=CategoryQueries.GETALLCATEGORIES, query=CategoryQueries.GETALLCATEGORIES_Q)
})
@Entity
@Table(name="category")
public class Category {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="category_sequence")
	@SequenceGenerator(initialValue= 1, name="category_sequence", allocationSize=1)
	private long id;
	@Column(name="name")
	private String name;
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="parentid")
	private Category parent;
	@OneToMany(mappedBy="category")
	private Set<Item> items;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Category getParent() {
		return parent;
	}
	public void setParent(Category parent) {
		this.parent = parent;
	}
	public Set<Item> getItems() {
		return items;
	}
	public void setItems(Set<Item> items) {
		this.items = items;
	}
	public long getId() {
		return id;
	}
	@SuppressWarnings("unused")
	private void setId(long id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", parent=" + parent
				+ ", items=" + items + "]";
	}
}
