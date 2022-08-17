package com.techelevator.projects.dao;

import com.techelevator.projects.model.Weapon;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

public class JdbcWeaponDao implements WeaponDao {

    private final JdbcTemplate jdbcTemplate;
    public JdbcWeaponDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }


    @Override
    public Weapon getWeapon(int weaponID) {
        Weapon weapon = null;

        String sql = "SELECT weapon_id, name, type_name, attack, description, weight, value " +
                "FROM weapon " +
                "JOIN weapon_type ON weapon_type.type_id = weapon_type.type_id " +
                "WHERE weapon.weapon_id = ?; ";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, weaponID);

        if (results.next()){
            weapon = mapRowToWeapon(results);
        }

        String sql2 = "SELECT weapon_id, element_name, element_att " +
                "FROM weapon_element " +
                "JOIN element_type ON element_type.element_id = weapon_element.element_id " +
                "WHERE weapon_id = ?; ";

        SqlRowSet results2 = jdbcTemplate.queryForRowSet(sql2, weaponID);

        Map<String, Integer> elements = new HashMap<>();

        while(results2.next()){
            String elementName = mapRowToWeaponElementName(results2);
            Integer elementAtt = mapRowToWeaponElementAtt(results2);
            elements.put(elementName, elementAtt);
        }

        weapon.setElementType(elements);

        return weapon;
    }

    private Weapon mapRowToWeapon(SqlRowSet rowSet) {
        Weapon weapon = new Weapon();

        weapon.setItemId(rowSet.getInt("weapon_id"));
        weapon.setName(rowSet.getString("name"));
        weapon.setItemType(rowSet.getString("type_name"));
        weapon.setAttack(rowSet.getInt("attack"));
        weapon.setItemDescription(rowSet.getString("description"));
        weapon.setItemWeight(rowSet.getDouble("weight"));
        weapon.setValue(rowSet.getInt("value"));

        return weapon;
    }

    private String mapRowToWeaponElementName(SqlRowSet rowSet){
        return rowSet.getString("element_name");
    }

    private int mapRowToWeaponElementAtt(SqlRowSet rowSet){
        return rowSet.getInt("element_att");
    }
}

