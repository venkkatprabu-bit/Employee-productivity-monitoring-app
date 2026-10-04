package com.example.rapidtech;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.annotation.NonNull;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Class;
import java.lang.Exception;
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
public final class ReportDao_Impl implements ReportDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Report> __insertionAdapterOfReport;

  public ReportDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfReport = new EntityInsertionAdapter<Report>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR ABORT INTO `reports` (`id`,`employeeCode`,`customerName`,`reportDate`,`problem`,`status`,`pdfPath`) VALUES (nullif(?, 0),?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Report entity) {
        statement.bindLong(1, entity.getId());
        statement.bindString(2, entity.getEmployeeCode());
        statement.bindString(3, entity.getCustomerName());
        statement.bindString(4, entity.getReportDate());
        statement.bindString(5, entity.getProblem());
        statement.bindString(6, entity.getStatus());
        statement.bindString(7, entity.getPdfPath());
      }
    };
  }

  @Override
  public Object insertReport(final Report report, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfReport.insert(report);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object getAllReports(final Continuation<? super List<Report>> $completion) {
    final String _sql = "SELECT * FROM reports";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<Report>>() {
      @Override
      @NonNull
      public List<Report> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfEmployeeCode = CursorUtil.getColumnIndexOrThrow(_cursor, "employeeCode");
          final int _cursorIndexOfCustomerName = CursorUtil.getColumnIndexOrThrow(_cursor, "customerName");
          final int _cursorIndexOfReportDate = CursorUtil.getColumnIndexOrThrow(_cursor, "reportDate");
          final int _cursorIndexOfProblem = CursorUtil.getColumnIndexOrThrow(_cursor, "problem");
          final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
          final int _cursorIndexOfPdfPath = CursorUtil.getColumnIndexOrThrow(_cursor, "pdfPath");
          final List<Report> _result = new ArrayList<Report>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Report _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpEmployeeCode;
            _tmpEmployeeCode = _cursor.getString(_cursorIndexOfEmployeeCode);
            final String _tmpCustomerName;
            _tmpCustomerName = _cursor.getString(_cursorIndexOfCustomerName);
            final String _tmpReportDate;
            _tmpReportDate = _cursor.getString(_cursorIndexOfReportDate);
            final String _tmpProblem;
            _tmpProblem = _cursor.getString(_cursorIndexOfProblem);
            final String _tmpStatus;
            _tmpStatus = _cursor.getString(_cursorIndexOfStatus);
            final String _tmpPdfPath;
            _tmpPdfPath = _cursor.getString(_cursorIndexOfPdfPath);
            _item = new Report(_tmpId,_tmpEmployeeCode,_tmpCustomerName,_tmpReportDate,_tmpProblem,_tmpStatus,_tmpPdfPath);
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
  public Object getReportsByEmployee(final String employeeCode,
      final Continuation<? super List<Report>> $completion) {
    final String _sql = "\n"
            + "        SELECT * FROM reports\n"
            + "        WHERE employeeCode = ?\n"
            + "        ";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindString(_argIndex, employeeCode);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<Report>>() {
      @Override
      @NonNull
      public List<Report> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfEmployeeCode = CursorUtil.getColumnIndexOrThrow(_cursor, "employeeCode");
          final int _cursorIndexOfCustomerName = CursorUtil.getColumnIndexOrThrow(_cursor, "customerName");
          final int _cursorIndexOfReportDate = CursorUtil.getColumnIndexOrThrow(_cursor, "reportDate");
          final int _cursorIndexOfProblem = CursorUtil.getColumnIndexOrThrow(_cursor, "problem");
          final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
          final int _cursorIndexOfPdfPath = CursorUtil.getColumnIndexOrThrow(_cursor, "pdfPath");
          final List<Report> _result = new ArrayList<Report>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Report _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpEmployeeCode;
            _tmpEmployeeCode = _cursor.getString(_cursorIndexOfEmployeeCode);
            final String _tmpCustomerName;
            _tmpCustomerName = _cursor.getString(_cursorIndexOfCustomerName);
            final String _tmpReportDate;
            _tmpReportDate = _cursor.getString(_cursorIndexOfReportDate);
            final String _tmpProblem;
            _tmpProblem = _cursor.getString(_cursorIndexOfProblem);
            final String _tmpStatus;
            _tmpStatus = _cursor.getString(_cursorIndexOfStatus);
            final String _tmpPdfPath;
            _tmpPdfPath = _cursor.getString(_cursorIndexOfPdfPath);
            _item = new Report(_tmpId,_tmpEmployeeCode,_tmpCustomerName,_tmpReportDate,_tmpProblem,_tmpStatus,_tmpPdfPath);
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
  public Object searchReports(final String search,
      final Continuation<? super List<Report>> $completion) {
    final String _sql = "\n"
            + "        SELECT * FROM reports\n"
            + "        WHERE customerName LIKE '%' || ? || '%'\n"
            + "        OR problem LIKE '%' || ? || '%'\n"
            + "        ";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    _statement.bindString(_argIndex, search);
    _argIndex = 2;
    _statement.bindString(_argIndex, search);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<Report>>() {
      @Override
      @NonNull
      public List<Report> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfEmployeeCode = CursorUtil.getColumnIndexOrThrow(_cursor, "employeeCode");
          final int _cursorIndexOfCustomerName = CursorUtil.getColumnIndexOrThrow(_cursor, "customerName");
          final int _cursorIndexOfReportDate = CursorUtil.getColumnIndexOrThrow(_cursor, "reportDate");
          final int _cursorIndexOfProblem = CursorUtil.getColumnIndexOrThrow(_cursor, "problem");
          final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
          final int _cursorIndexOfPdfPath = CursorUtil.getColumnIndexOrThrow(_cursor, "pdfPath");
          final List<Report> _result = new ArrayList<Report>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Report _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpEmployeeCode;
            _tmpEmployeeCode = _cursor.getString(_cursorIndexOfEmployeeCode);
            final String _tmpCustomerName;
            _tmpCustomerName = _cursor.getString(_cursorIndexOfCustomerName);
            final String _tmpReportDate;
            _tmpReportDate = _cursor.getString(_cursorIndexOfReportDate);
            final String _tmpProblem;
            _tmpProblem = _cursor.getString(_cursorIndexOfProblem);
            final String _tmpStatus;
            _tmpStatus = _cursor.getString(_cursorIndexOfStatus);
            final String _tmpPdfPath;
            _tmpPdfPath = _cursor.getString(_cursorIndexOfPdfPath);
            _item = new Report(_tmpId,_tmpEmployeeCode,_tmpCustomerName,_tmpReportDate,_tmpProblem,_tmpStatus,_tmpPdfPath);
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
