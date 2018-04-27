package ch.carve.cassandra;

import com.datastax.driver.core.ResultSet;
import com.datastax.driver.mapping.Result;
import com.datastax.driver.mapping.annotations.Accessor;
import com.datastax.driver.mapping.annotations.Query;

@Accessor
public interface TrxRecordAccessor {

    @Query("select * from jax.trx")
    Result<TrxRecord> getAll();

    @Query("insert into jax.trx (trxid, amount, merchant) values (?, ?, ?)")
    ResultSet insert(long trxid, int amount, String merchant);
}
