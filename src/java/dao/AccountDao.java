/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import javax.sql.DataSource;
import model.Account;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author sanket
 */
public class AccountDao {
    
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;
    
            public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }
            
            
    public void create(Account account) {
        String sql = "INSERT INTO ACCOUNT (NAME,AGE,DOB,IFSC,AADHAR,"
                + "EMAIL,MOBILENO,FATHERNAME,ANNUALINCOME,ADDRESS,NOMINEENAME,RELATIONSHIP,NOMINEEADDRESS) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
        jdbcTemplate = new JdbcTemplate(dataSource);
        int i=jdbcTemplate.update(sql, new Object[]{account.getName(), account.getAge(),account.getDob()
                ,account.getIfsc(),account.getAadhar(),account.getEmail(),account.getMobileNo(),account.getFatherName(),
                account.getAnnualIncome(),account.getAddress(),account.getNomineeName(),account.getRelationship(),account.getNomineeAddress()});
    }
            
     
    public List<Account> readAll() {
        jdbcTemplate = new JdbcTemplate(dataSource);
        String sql = "SELECT * FROM ACCOUNT";
        return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Account.class));
    }
    
     public int checkAadhar(String aadharNumber) {
        jdbcTemplate = new JdbcTemplate(dataSource);
        String sql = "SELECT count(*) FROM ACCOUNT WHERE AADHAR=?";
//        Account ac= jdbcTemplate.queryForObject(sql,new Object[]{aadharNumber},BeanPropertyRowMapper.newInstance(Account.class));
            int count = jdbcTemplate.queryForObject(
                        sql, new Object[] { aadharNumber }, Integer.class);
        return count;
        
    }
}
