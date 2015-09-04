<?php 

  //--------------------------------------------------------------------------
  // Example php script for fetching data from mysql database
  //--------------------------------------------------------------------------
  $host = "localhost";
  $user = "admin";
  $pass = "kurs2015";

  $databaseName = "ims";
  $tableName = "measurement_results";

  //--------------------------------------------------------------------------
  // 1) Connect to mysql database
  //--------------------------------------------------------------------------
  
  $con = mysql_connect($host,$user,$pass);
  $dbs = mysql_select_db($databaseName, $con);

  //--------------------------------------------------------------------------
  // 2) Query database for data
  //--------------------------------------------------------------------------
  $result = mysql_query("SELECT * FROM measurement_results ORDER BY time DESC LIMIT 1");          //query  
 
  $line = mysql_fetch_array($result, MYSQL_ASSOC);    
  
  echo json_encode($line);  

?>