import java.util.List;

import javax.persistence.criteria.CriteriaQuery;
import javax.transaction.Transactional;

import org.hibernate.Session;

public class UsersCRUD {
	
	public void save(Users users) {
		Session session = HibernateUtil.getSessionFactory().openSession(); //��������� ������
		session.beginTransaction();
		session.save(users); //���������� �� ��������
		session.flush();
		session.close();
	}
	
	public void delete(Users users) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.delete(users);
		session.flush();
		session.close();
	}
	
	public List<Users> getAll(){
		Session session = HibernateUtil.getSessionFactory().openSession();
        return session.createCriteria(Users.class).list();
	}
	
	public Users getById(Integer id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Users users = session.get(Users.class, id);
		return users;
	}

}
