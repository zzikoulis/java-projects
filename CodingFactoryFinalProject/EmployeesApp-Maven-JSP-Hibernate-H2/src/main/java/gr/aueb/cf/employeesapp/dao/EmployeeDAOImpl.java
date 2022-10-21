package gr.aueb.cf.employeesapp.dao;

import java.util.List;
import gr.aueb.cf.employeesapp.service.util.JPAHelper;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.ParameterExpression;
import jakarta.persistence.criteria.Root;
import gr.aueb.cf.employeesapp.model.Employee;

public class EmployeeDAOImpl implements IEmployeeDAO {

	@Override
	public void insert(Employee employee) {
		EntityManager em = getEntityManager();
		em.persist(employee);
	}

	@Override
	public void delete(Employee employee) {
		EntityManager em = getEntityManager();
		Employee toDelete = em.find(Employee.class, employee.getId());
		em.remove(toDelete);
	}

	@Override
	public void update(Employee employee) {
		getEntityManager().merge(employee);
	}

	@Override
	public List<Employee> getEmployeesByLastname(String surname) {
		CriteriaBuilder builder = getEntityManager().getCriteriaBuilder();

		CriteriaQuery<Employee> selectQuery = builder.createQuery(Employee.class);

		Root<Employee> root = selectQuery.from(Employee.class);
		
		ParameterExpression<String> val = builder.parameter(String.class, "employeeLastname");
		
		selectQuery.select(root).where(builder.like(root.get("lastname"), val));
		
		TypedQuery<Employee> query = getEntityManager().createQuery(selectQuery).setParameter("employeeLastname", surname + "%");
		return query.getResultList();
	}

	@Override
	public Employee getEmployeeById(Long id) {
		return getEntityManager().find(Employee.class, id);
	}
	
	private EntityManager getEntityManager() {
		return JPAHelper.getEntityManager();
	}
}
