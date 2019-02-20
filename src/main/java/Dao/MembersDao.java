package Dao;

import entity.Members;

import java.util.List;

/**
 * Created by LENOVO on 2019-01-19.
 */
public interface MembersDao {
    List<Members> select();
    Members selectByid(Integer id);
    int Update(Members members);
}
