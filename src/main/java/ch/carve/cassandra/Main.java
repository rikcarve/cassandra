package ch.carve.cassandra;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Session;
import com.datastax.driver.mapping.Mapper;
import com.datastax.driver.mapping.MappingManager;

public class Main {

    private static final String CREATE_KEYPSACE = "CREATE KEYSPACE IF NOT EXISTS jax WITH REPLICATION = {'class':'SimpleStrategy', 'replication_factor':1}";
    private static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS jax.trx (trxid bigint PRIMARY KEY, amount int, merchant text);";

    public static void main(String[] args) {
        Cluster cluster = Cluster.builder().addContactPoint("localhost").build();
        Session session = cluster.connect();
        // session.execute(CREATE_KEYPSACE);
        // session.execute(CREATE_TABLE);

        MappingManager manager = new MappingManager(session);
        Mapper<TrxRecord> mapper = manager.mapper(TrxRecord.class);
        // TrxRecord trx1 = new TrxRecord(17, 120, "DB");
        // mapper.save(trx1);

        ResultSet rs = session.execute("select * from jax.trx");
        mapper.map(rs).forEach(t -> System.out.println(t.getTrxid() + ";" + t.getMerchant()));

        System.out.println(mapper.get(1L).getMerchant());

        // accessor
        TrxRecordAccessor trxAccessor = manager.createAccessor(TrxRecordAccessor.class);
        trxAccessor.getAll().forEach(t -> System.out.println(t.getTrxid() + ";" + t.getMerchant()));

        session.close();
        cluster.close();
    }

}
