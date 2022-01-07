/*****************************************************
 * Implementation of connecting to mysql database
 * and fetching column names, values, and metadata.
 * Users can parse queries in the form of parameters
 *
 * Created and Code By Ary Herijanto
 * Date January 7th, 2022
 * aherijanto@gmail.com
 */

import java.sql.*;

public class ConnectDB {
    private String _urlDB;
    private String _username;
    private String _password;
    private Connection _Connection_;
    private ResultSet _ResultSet_;
    public  String[] _metaDataCol;

    public ConnectDB(String _urlDB, String _username, String _password){
        this._urlDB = _urlDB;
        this._username = _username;
        this._password = _password;
        initConn();
    }

    public void initConn(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch(ClassNotFoundException e){

        }
    }

    public void _Connection(){
        try {
            Connection _Connection = DriverManager.getConnection(this._urlDB,this._username,this._password);
            this._Connection_ = _Connection;
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public void _Statement(String _Query) throws SQLException {
        Statement _myStatement = this._Connection_.createStatement();
        ResultSet _Resultset = _myStatement.executeQuery(_Query);
        this._ResultSet_ = _Resultset;
    }

    public void _Result() throws SQLException {
        _getMetaData();
        int _counterSet = _metaDataCol.length;
        while(this._ResultSet_.next()){
            for(int i = 0 ; i <_counterSet;i++){
                System.out.println(this._ResultSet_.getString(_metaDataCol[i])+" ");
            }
        }
    }

    public void _getMetaData() throws SQLException {
        ResultSetMetaData _metaData = this._ResultSet_.getMetaData();
        int _counter = _metaData.getColumnCount();
        _metaDataCol = new String[_counter];
        for(int colCounter = 1;colCounter <=_counter;colCounter++){
            _metaDataCol[colCounter-1] = _metaData.getColumnName(colCounter);
        }

    }

    public void _printMetaData(){
        for(String _meta:_metaDataCol ){
            System.out.println("\n Meta Data  = ");
            System.out.println(_meta);
        }
    }
}
