package org.apache.spark.sql.cassandra.api.java

import org.apache.spark.api.java.JavaSparkContext
import org.apache.spark.sql.SchemaRDD
import org.apache.spark.sql.api.java.{JavaSchemaRDD, JavaSQLContext}
import org.apache.spark.sql.cassandra.CassandraHiveSQLContext
import org.apache.spark.sql.hive.CassandraHiveQl

/**
 *
 */
class JavaCassandraHiveSQLContext(sparkContext: JavaSparkContext) extends JavaCassandraSQLContext(sparkContext) {

   override val sqlContext = new CassandraHiveSQLContext(sparkContext)
}

