package Service.Impl;

import Dao.Impl.MembersDaoimpl;
import Dao.MembersDao;
import Service.MembersService;
import entity.Members;

import java.util.List;

/**
 * Created by LENOVO on 2019-01-19.
 */
public class MembersServiceImpl implements MembersService {
    MembersDao membersDao=new MembersDaoimpl();
    @Override
    public List<Members> select() {
        return membersDao.select();
    }

    @Override
    public Members selectByid(Integer id) {
        return membersDao.selectByid(id);
    }

    @Override
    public int Update(Members members) {
        return membersDao.Update(members);
    }
}
