package com.hakstrace.system.menu.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import com.hakstrace.framework.domain.Domain;

@Entity
@Table(name="menu")
public class Menu extends Domain{

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="menu_id", nullable = false)
	private String menuId;

	@Column(name="menu_name", nullable = false)
	private String menuName;
	
	@Column(name="url")
	private String url;
	
	@Column(name="level")
	private int level;
	
	@Column(name="seq")
	private int seq;
	
	@ManyToOne
	@JoinColumn(name="parent_menu_id")
	private Menu parent;

	@OneToMany(mappedBy="parent")
	@OrderBy("seq")
	private List<Menu> children;

	public String getMenuId() {
		return menuId;
	}

	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}
	
	public int getSeq(){
		return seq;
	}
	
	public void setSeq(int seq){
		this.seq = seq;
	}

	public Menu getParent() {
		return parent;
	}

	public void setParent(Menu parent) {
		this.parent = parent;
	}

	public List<Menu> getChildren() {
		return children;
	}

	public void setChildren(List<Menu> children) {
		this.children = children;
	}
	
	
	
}
