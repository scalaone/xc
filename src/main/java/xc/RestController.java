package xc;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.PostConstruct;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by changhai on 15/9/21.
 */
@Controller
public class RestController {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @PostConstruct
    public void init() {
        System.out.println("init");
    }

    @RequestMapping("/test")
    @ResponseBody
    public Haha test(@RequestBody Haha haha) {
        System.out.println(ToStringBuilder.reflectionToString(haha));
        return haha;
    }

    @RequestMapping("/db")
    @ResponseBody
    public Haha db() {
        List<Haha> hahaList = jdbcTemplate.query("select * from haha", new RowMapper<Haha>() {
            public Haha mapRow(ResultSet rs, int rowNum) throws SQLException {
                Haha haha = new Haha();
                haha.setId(rs.getString("id"));
                haha.setName(rs.getString("name"));
                return haha;
            }
        });
        for (int i = 0; i < hahaList.size(); i++) {
            System.out.println(ToStringBuilder.reflectionToString(hahaList.get(i)));
        }
        return hahaList.get(0);
    }
}
