package Dao.Impl;

import Dao.BaseDao;
import Dao.MembersDao;
import entity.Members;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by LENOVO on 2019-01-19.
 */
public class MembersDaoimpl extends BaseDao implements MembersDao{
    @Override
    public List<Members> select() {
        List<Members> list=new ArrayList<>();
        conn=connection();
        String sql="select * from membersinfo";
        try {
            pstmt=conn.prepareStatement(sql);
            rs=pstmt.executeQuery();
            while (rs.next()){
                Members members=new Members();
                members.setMid(rs.getInt("mid"));
                members.setMaddress(rs.getString("maddress"));
                members.setMage(rs.getInt("mage"));
                members.setMemail(rs.getString("maddress"));
                members.setMgender(rs.getString("mgender"));
                members.setMname(rs.getString("mname"));
                list.add(members);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public Members selectByid(Integer id) {
        Members members=new Members();
        conn=connection();
        String sql="select mid,mname,mgender,mage,maddress,memail from membersinfo where mid=?";
        try {
            pstmt=conn.prepareStatement(sql);
            pstmt.setInt(1,id);
            rs=pstmt.executeQuery();
            while (rs.next()){
                members.setMid(rs.getInt("mid"));
                members.setMaddress(rs.getString("maddress"));
                members.setMage(rs.getInt("mage"));
                members.setMemail(rs.getString("maddress"));
                members.setMgender(rs.getString("mgender"));
                members.setMname(rs.getString("mname"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return members;
    }

    @Override
    public int Update(Members members) {
        conn=connection();
        String sql="update membersinfo set mname=?,mgender=?,mage=?,maddress=?,memail=? where mid=?";
        Object[] objects={
                members.getMname(),
                members.getMgender(),
                members.getMage(),
                members.getMaddress(),
                members.getMemail(),
                members.getMid()
        };
        return exceuteUpdate(sql,objects);
    }
}
