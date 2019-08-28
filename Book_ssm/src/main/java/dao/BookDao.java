package dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import model.Book;

@Repository
public interface BookDao {
	
	@Select("select book.*, type.name typename from book inner join type on book.typeid=type.id ${where}")
	public List<Book> select(@Param(value = "where") String where);
	
	@Select("select book.*, type.name typename from book inner join type on book.typeid=type.id where book.id=#{id}")
	public Book selectById(int id);
	
	@Delete("delete from book where id=#{id}")
	public void delete(int id);
	
	@Update("update book set name=#{name}, state=#{state}, typeid=#{typeid} where id = #{id}")
	public void update(Book b);
	
	@Insert("insert into book(name,state,typeid) values(#{name},#{state},#{typeid})")
	public void insert(Book b);
}
