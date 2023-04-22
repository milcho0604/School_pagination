package net.skhu.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import net.skhu.dto.User;
import net.skhu.model.Pagination;

@Mapper
public interface UserMapper {

    @Select("""
        SELECT u.*, d.name departmentName
        FROM user u LEFT JOIN department d ON u.departmentId = d.id
        ORDER BY u.id
        LIMIT #{firstRecordIndex}, #{sz} """)
    List<User> findAll(Pagination pagination);

    @Select("SELECT COUNT(id) FROM user")
    int getCount();

    @Select("SELECT * FROM user WHERE id = #{id}")
    User findOne(int id);

    @Insert("""
        INSERT user (loginName, name, departmentId, password, userType, email, enabled)
        VALUES (#{loginName}, #{name}, #{departmentId}, #{password}, #{userType}, #{email}, #{enabled}) """)
    void insert(User user);

    @Update("""
        UPDATE user SET
          loginName = #{loginName},
          name = #{name},
          departmentId = #{departmentId},
          password = #{password},
          userType = #{userType},
          email = #{email}
        WHERE id = #{id} """)
    void update(User user);

    @Delete("DELETE FROM user WHERE id = #{id}")
    void deleteById(int id);
}
