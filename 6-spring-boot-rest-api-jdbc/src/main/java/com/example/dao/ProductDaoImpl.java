package com.example.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.model.Product;
@Component
public class ProductDaoImpl implements ProductDao {
	@Autowired
DBConnection dbConnection;
	@Override
	public Product addNewProduct(Product p) {
		System.out.println("---adding new product");
		Connection con=  dbConnection.getConnection();
		String sql="insert into Product values(?,?,?,?)";
		try {
			//pre-compiled sql stmt
			//supports parameterized queries
			PreparedStatement pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, p.getProdId());
			pstmt.setString(2, p.getProdName());
			pstmt.setFloat(3, p.getPrice());
			LocalDate d=p.getManufactureDate();
			pstmt.setDate(4, Date.valueOf(d));
		  int c=  pstmt.executeUpdate();
		  System.out.println(c+" no of rows affected .....");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//invokes getConnection
		//create stmt object
		//execute the the query
		return p;
	}

	@Override
	public List<Product> allProducts() {
		Connection con=  dbConnection.getConnection();
		String sql="select * from Product";
		List<Product> list= new ArrayList<>();
		try {
			PreparedStatement pstmt=con.prepareStatement(sql);
			ResultSet rs=  pstmt.executeQuery();
			///navigate all the records and store in the list and then
			//return the list
			//in default rs points to before 1st record
			while(rs.next()) {
				int id=rs.getInt("prodId");
				String pname=rs.getString("prodName");
				float price=rs.getFloat("price");
				Date sqlDate=  rs.getDate("manufacturedDate");
				Product p=new Product();
				p.setProdId(id);
				p.setProdName(pname);
				p.setPrice(price);
				p.setManufactureDate(sqlDate.toLocalDate());
				list.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Product searchById(int productId) {
		Connection con=  dbConnection.getConnection();
		String sql="select * from Product where prodId=?";
		try {
			PreparedStatement pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, productId);
			
			ResultSet rs=  pstmt.executeQuery();
			if(rs.next()) {
				Product p=new Product();
				p.setProdId(rs.getInt("prodId"));
				p.setProdName(rs.getString("prodName"));
				p.setPrice(rs.getFloat("price"));
				p.setManufactureDate(rs.getDate("manufacturedDate").toLocalDate());
				return p;
			}
		}
		catch(Exception e) {
			
		}
		return null;
	}

	@Override
	public void deleteProduct(int productId) {
		Connection con=  dbConnection.getConnection();
		String sql="delete from Product where prodId=?";
		try {
			PreparedStatement pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, productId);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
