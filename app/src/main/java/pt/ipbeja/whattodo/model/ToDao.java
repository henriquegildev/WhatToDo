package pt.ipbeja.whattodo.model;
import java.util.List;

import androidx.core.database.sqlite.SQLiteDatabaseKt;

@Dao
abstract class ToDao {

    @Query("select * from todo")
    abstract fun getAll() : List<Todo>

    @Query("select * from todo")
    abstract fun getAll() : List<Todo>

    @Query("select * from todo")
    abstract fun getAll() : List<Todo>
}
