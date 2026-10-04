package com.example.rapidtech;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.annotation.NonNull;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
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
public final class AttendanceDao_Impl implements AttendanceDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Attendance> __insertionAdapterOfAttendance;

  private final SharedSQLiteStatement __preparedStmtOfUpdateCheckOut;

  public AttendanceDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfAttendance = new EntityInsertionAdapter<Attendance>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR ABORT INTO `attendance` (`id`,`employeeCode`,`employeeName`,`date`,`checkIn`,`checkOut`) VALUES (nullif(?, 0),?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Attendance entity) {
        statement.bindLong(1, entity.getId());
        statement.bindString(2, entity.getEmployeeCode());
        statement.bindString(3, entity.getEmployeeName());
        statement.bindString(4, entity.getDate());
        statement.bindString(5, entity.getCheckIn());
        statement.bindString(6, entity.getCheckOut());
      }
    };
    this.__preparedStmtOfUpdateCheckOut = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "\n"
                + "        UPDATE attendance\n"
                + "        SET checkOut = ?\n"
                + "        WHERE employeeCode = ?\n"
                + "        AND date = ?\n"
                + "        ";
        return _query;
      }
    };
  }

  @Override
  public Object insertAttendance(final Attendance attendance,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfAttendance.insert(attendance);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object updateCheckOut(final String employeeCode, final String date, final String checkOut,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateCheckOut.acquire();
        int _argIndex = 1;
        _stmt.bindString(_argIndex, checkOut);
        _argIndex = 2;
        _stmt.bindString(_argIndex, employeeCode);
        _argIndex = 3;
        _stmt.bindString(_argIndex, date);
        try {
          __db.beginTransaction();
          try {
            _stmt.executeUpdateDelete();
            __db.setTransactionSuccessful();
            return Unit.INSTANCE;
          } finally {
            __db.endTransaction();
          }
        } finally {
          __preparedStmtOfUpdateCheckOut.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Object getAllAttendance(final Continuation<? super List<Attendance>> $completion) {
    final String _sql = "SELECT * FROM attendance ORDER BY id DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<Attendance>>() {
      @Override
      @NonNull
      public List<Attendance> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfEmployeeCode = CursorUtil.getColumnIndexOrThrow(_cursor, "employeeCode");
          final int _cursorIndexOfEmployeeName = CursorUtil.getColumnIndexOrThrow(_cursor, "employeeName");
          final int _cursorIndexOfDate = CursorUtil.getColumnIndexOrThrow(_cursor, "date");
          final int _cursorIndexOfCheckIn = CursorUtil.getColumnIndexOrThrow(_cursor, "checkIn");
          final int _cursorIndexOfCheckOut = CursorUtil.getColumnIndexOrThrow(_cursor, "checkOut");
          final List<Attendance> _result = new ArrayList<Attendance>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Attendance _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpEmployeeCode;
            _tmpEmployeeCode = _cursor.getString(_cursorIndexOfEmployeeCode);
            final String _tmpEmployeeName;
            _tmpEmployeeName = _cursor.getString(_cursorIndexOfEmployeeName);
            final String _tmpDate;
            _tmpDate = _cursor.getString(_cursorIndexOfDate);
            final String _tmpCheckIn;
            _tmpCheckIn = _cursor.getString(_cursorIndexOfCheckIn);
            final String _tmpCheckOut;
            _tmpCheckOut = _cursor.getString(_cursorIndexOfCheckOut);
            _item = new Attendance(_tmpId,_tmpEmployeeCode,_tmpEmployeeName,_tmpDate,_tmpCheckIn,_tmpCheckOut);
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
  public Object getAttendanceCount(final Continuation<? super Integer> $completion) {
    final String _sql = "SELECT COUNT(*) FROM attendance";
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

  @Override
  public Object getAttendanceByEmployee(final String employeeCode,
      final Continuation<? super List<Attendance>> $completion) {
    final String _sql = "\n"
            + "        SELECT * FROM attendance\n"
            + "        WHERE employeeCode = ?\n"
            + "        ORDER BY id DESC\n"
            + "        ";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindString(_argIndex, employeeCode);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<Attendance>>() {
      @Override
      @NonNull
      public List<Attendance> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfEmployeeCode = CursorUtil.getColumnIndexOrThrow(_cursor, "employeeCode");
          final int _cursorIndexOfEmployeeName = CursorUtil.getColumnIndexOrThrow(_cursor, "employeeName");
          final int _cursorIndexOfDate = CursorUtil.getColumnIndexOrThrow(_cursor, "date");
          final int _cursorIndexOfCheckIn = CursorUtil.getColumnIndexOrThrow(_cursor, "checkIn");
          final int _cursorIndexOfCheckOut = CursorUtil.getColumnIndexOrThrow(_cursor, "checkOut");
          final List<Attendance> _result = new ArrayList<Attendance>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Attendance _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpEmployeeCode;
            _tmpEmployeeCode = _cursor.getString(_cursorIndexOfEmployeeCode);
            final String _tmpEmployeeName;
            _tmpEmployeeName = _cursor.getString(_cursorIndexOfEmployeeName);
            final String _tmpDate;
            _tmpDate = _cursor.getString(_cursorIndexOfDate);
            final String _tmpCheckIn;
            _tmpCheckIn = _cursor.getString(_cursorIndexOfCheckIn);
            final String _tmpCheckOut;
            _tmpCheckOut = _cursor.getString(_cursorIndexOfCheckOut);
            _item = new Attendance(_tmpId,_tmpEmployeeCode,_tmpEmployeeName,_tmpDate,_tmpCheckIn,_tmpCheckOut);
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

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
