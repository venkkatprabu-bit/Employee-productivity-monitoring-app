package com.example.rapidtech;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import javax.annotation.processing.Generated;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class EmployeeDao_Impl implements EmployeeDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Employee> __insertionAdapterOfEmployee;

  public EmployeeDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfEmployee = new EntityInsertionAdapter<Employee>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR ABORT INTO `employees` (`id`,`employeeCode`,`employeeName`,`password`,`designation`) VALUES (nullif(?, 0),?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Employee entity) {
        statement.bindLong(1, entity.getId());
        statement.bindString(2, entity.getEmployeeCode());
        statement.bindString(3, entity.getEmployeeName());
        statement.bindString(4, entity.getPassword());
        statement.bindString(5, entity.getDesignation());
      }
    };
  }

  @Override
  public Object insertEmployee(final Employee employee,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfEmployee.insert(employee);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object loginEmployee(final String employeeCode, final String password,
      final Continuation<? super Employee> $completion) {
    final String _sql = "\n"
            + "        SELECT * FROM employees\n"
            + "        WHERE employeeCode = ?\n"
            + "        AND password = ?\n"
            + "        LIMIT 1\n"
            + "        ";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    _statement.bindString(_argIndex, employeeCode);
    _argIndex = 2;
    _statement.bindString(_argIndex, password);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<Employee>() {
      @Override
      @Nullable
      public Employee call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfEmployeeCode = CursorUtil.getColumnIndexOrThrow(_cursor, "employeeCode");
          final int _cursorIndexOfEmployeeName = CursorUtil.getColumnIndexOrThrow(_cursor, "employeeName");
          final int _cursorIndexOfPassword = CursorUtil.getColumnIndexOrThrow(_cursor, "password");
          final int _cursorIndexOfDesignation = CursorUtil.getColumnIndexOrThrow(_cursor, "designation");
          final Employee _result;
          if (_cursor.moveToFirst()) {
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpEmployeeCode;
            _tmpEmployeeCode = _cursor.getString(_cursorIndexOfEmployeeCode);
            final String _tmpEmployeeName;
            _tmpEmployeeName = _cursor.getString(_cursorIndexOfEmployeeName);
            final String _tmpPassword;
            _tmpPassword = _cursor.getString(_cursorIndexOfPassword);
            final String _tmpDesignation;
            _tmpDesignation = _cursor.getString(_cursorIndexOfDesignation);
            _result = new Employee(_tmpId,_tmpEmployeeCode,_tmpEmployeeName,_tmpPassword,_tmpDesignation);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @Override
  public Object getAllEmployees(final Continuation<? super List<Employee>> $completion) {
    final String _sql = "SELECT * FROM employees";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<Employee>>() {
      @Override
      @NonNull
      public List<Employee> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfEmployeeCode = CursorUtil.getColumnIndexOrThrow(_cursor, "employeeCode");
          final int _cursorIndexOfEmployeeName = CursorUtil.getColumnIndexOrThrow(_cursor, "employeeName");
          final int _cursorIndexOfPassword = CursorUtil.getColumnIndexOrThrow(_cursor, "password");
          final int _cursorIndexOfDesignation = CursorUtil.getColumnIndexOrThrow(_cursor, "designation");
          final List<Employee> _result = new ArrayList<Employee>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Employee _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpEmployeeCode;
            _tmpEmployeeCode = _cursor.getString(_cursorIndexOfEmployeeCode);
            final String _tmpEmployeeName;
            _tmpEmployeeName = _cursor.getString(_cursorIndexOfEmployeeName);
            final String _tmpPassword;
            _tmpPassword = _cursor.getString(_cursorIndexOfPassword);
            final String _tmpDesignation;
            _tmpDesignation = _cursor.getString(_cursorIndexOfDesignation);
            _item = new Employee(_tmpId,_tmpEmployeeCode,_tmpEmployeeName,_tmpPassword,_tmpDesignation);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @Override
  public Object getEmployeeCount(final Continuation<? super Integer> $completion) {
    final String _sql = "SELECT COUNT(*) FROM employees";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<Integer>() {
      @Override
      @NonNull
      public Integer call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final Integer _result;
          if (_cursor.moveToFirst()) {
            final int _tmp;
            _tmp = _cursor.getInt(0);
            _result = _tmp;
          } else {
            _result = 0;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
