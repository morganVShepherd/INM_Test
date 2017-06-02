package hire.morgan.constants;

/**
 * Created by morgan.shepherd
 */

public class Constants {
    //APP Data Value names
    public static final String ACCESS_TOKEN = "ACCESS_TOKEN";
    public static final String APP_ID ="APP_ID";
    public static final String APP_SECRET="APP_SECRET";
    public static final String PAGE_ID= "PAGE_ID";
    public static final String UPDATED_DATE= "UPDATED_DATE";

    //For Postgress DB
    public static final String PATH = "jdbc:postgresql://localhost:5432/inm";
    public static final String UNAME="postgres";
    public static final String PASS="root";
    public static final String FOR_NAME ="org.postgresql.Driver";

    //For mysql DB
    //public static final String PATH = "jdbc:mysql://localhost:3306/inm";
    //public static final String UNAME="root";
    //public static final String PASS="root";
    //public static final String FOR_NAME ="com.mysql.jdbc.Driver";


    public static final String SQL = "create schema inm;<br/>" +
            "<br/>" +
            "create table app_data(<br/>" +
            "name varchar(255),<br/>" +
            "value varchar(255)<br/>" +
            ");<br/>" +
            "<br/>" +
            "create table post_details (<br/>" +
            "post_detail_id bigint not null ,<br/>" +
            "parent_id bigint ,<br/>" +
            "created_date timestamp without time zone not null,<br/>" +
            "updated_date timestamp without time zone not null,<br/>" +
            "type_fb_post varchar(255),<br/>" +
            "content varchar(255),<br/>" +
            "html varchar(255),<br/>" +
            "likes int,<br/>" +
            "shares int,<br/>" +
            "comments int,<br/>" +
            "impressions int,<br/>" +
            "reach int,<br/>" +
            "engagement int,<br/>" +
            "engagers int,<br/>" +
            "PRIMARY KEY (post_detail_id)<br/>" +
            ");<br/>" +
            "<br/>" +
            "#I generally add index after table creation<br/>" +
            "<br/>" +
            "create index post_id_index on post_details using btree(post_detail_id);<br/>" +
            "<br/>" +
            "<br/>" +
            "#Inserts:<br/>" +
            "insert into app_data values('UPDATED_DATE', '01-06-2017 08:00:00');<br/>" +
            "insert into app_data values('ACCESS_TOKEN', 'yourToken');<br/>" +
            "<br/>" +
            "insert into app_data values('APP_ID', 'yourAppId');<br/>" +
            "<br/>" +
            "insert into app_data values('APP_SECRET', 'yourAppSecret');<br/>" +
            "<br/>" +
            "insert into app_data values('PAGE_ID', 'yourPageId');";





}
