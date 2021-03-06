package br.com.framework.interfac.crud;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public interface InterfaceCrud<T> extends Serializable {

	void save(T obj) throws Exception;
	
	void persist(T obj) throws Exception;

	T saveRetorno(T obj) throws Exception;

	void saveOrUpdate(Object obj) throws Exception;

	void update(T obj) throws Exception;

	void delete(T obj) throws Exception;

	T merge(T obj) throws Exception;
	
	// limpa a sess�o do Hibernate
	void clearSession() throws Exception;
	
	T findMaxObjectEntity(Class<T> classObj) throws Exception;

	List<T> finList(Class<T> obj) throws Exception;

	Object findById(Class<T> entidade, Long id) throws Exception;

	List<T> findListByProperty(Class<T> entidade, Object atributo, Object valor)
			throws Exception;

	List<T> findListByListDeIds(Class<T> obj, List<Long> cods) throws Exception;

	List<T> findListByQueryDinamica(String s) throws Exception;

	// executa update com HQL
	void executeUpdateQueryDinamica(String s) throws Exception;

	// executa update com SQL
	void executeUpdateSQLDinamica(String s) throws Exception;

	// Retira um objeto da sess�o do hibernate
	void evict(Object obj) throws Exception;

	T carregar(Class<T> class1, Long long1) throws Exception;

	Class<T> getClass(Class<T> entidade) throws Exception;

	List<T> findListByLike(Class<T> entidade, String atributoClass, String valor)
			throws Exception;

	List<T> findByPropertyId(Class<T> entidade, Long id, Object atributo)
			throws Exception;

	// retorna a sess�o do Hibernate
	Session getSession() throws Exception;

	List<?> getListSQLDinamica(String sql) throws Exception;

	T findUninqueByPropertyId(Class<T> entidade, Long id, Object atributo)
			throws Exception;

	T findUniqueByQueryDinamica(String query) throws Exception;

	void executeUpdateSQLDinamica(String query, Long... cods) throws Exception;

	List<T> finListOrderByProperty(Class<T> entidade, String propriedade)
			throws Exception;

	T findUninqueByProperty(Class<T> entidade, Object valor, String atributo)
			throws Exception;

	T findUninqueByPropertyId(Class<T> entidade, Long id, Object atributo,
			String condicaoAdicional) throws Exception;

	// JDBC do Spring 
	JdbcTemplate getJdbcTemplate();
	SimpleJdbcTemplate getSimpleJdbcTemplate();
	SimpleJdbcInsert getSimpleJdbcInsert();
	
	public T findUninqueByProperty(Class<T> entidade, Object valor,
			String atributo, String condicao) throws Exception;
	
	Long totalRegistro(String tabela) throws Exception;
	
	Query obterQuery(String query) throws Exception;
	
	// Carregamento dinamico com JSF e PrimeFaces
	List<T> findListByQueryDinamica(String query, int iniciaNoRegistro, int maximoResultado) throws Exception; 
}
