package org.apache.spark.sql.cassandra

import org.apache.spark.sql.SchemaRDD
import org.apache.spark.sql.catalyst.plans.logical.LogicalPlan
import org.apache.spark.sql.hive.CassandraHiveQl
import org.apache.spark.SparkContext


/**
 *
 */
class CassandraHiveSQLContext(sc: SparkContext) extends CassandraSQLContext(sc) {

   /** Executes SQL query against Cassandra and returns SchemaRDD representing the result. */
   override def cassandraSql(cassandraQuery: String): SchemaRDD =  new SchemaRDD(this, parseSql(cassandraQuery))

   override protected[sql] def parseSql(sql: String): LogicalPlan = {
      if (dialect == "sql") {
         super.parseSql(sql)
      } else if (dialect == "hiveql") {
         CassandraHiveQl.parseSql(sql)
      }  else {
         sys.error(s"Unsupported SQL dialect: $dialect.  Try 'sql' or 'hiveql'")
      }
   }
}
