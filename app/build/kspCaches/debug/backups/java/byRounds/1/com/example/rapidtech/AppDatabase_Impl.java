package com.example.rapidtech;

import androidx.annotation.NonNull;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomOpenHelper;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.processing.Generated;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class AppDatabase_Impl extends AppDatabase {
  private volatile ReportDao _reportDao;

  private volatile AttendanceDao _attendanceDao;

  private volatile EmployeeDao _employeeDao;

  @Override
  @NonNull
  protected SupportSQLiteOpenHelper createOpenHelper(@NonNull final DatabaseConfiguration config) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(config, new RoomOpenHelper.Delegate(5) {
      @Override
      public void createAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS `reports` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `employeeCode` TEXT NOT NULL, `customerName` TEXT NOT NULL, `reportDate` TEXT NOT NULL, `problem` TEXT NOT NULL, `status` TEXT NOT NULL, `pdfPath` TEXT NOT NULL)");
        db.execSQL("CREATE TABLE IF NOT EXISTS `attendance` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `employeeCode` TEXT NOT NULL, `employeeName` TEXT NOT NULL, `date` TEXT NOT NULL, `checkIn` TEXT NOT NULL, `checkOut` TEXT NOT NULL)");
        db.execSQL("CREATE TABLE IF NOT EXISTS `employees` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `employeeCode` TEXT NOT NULL, `employeeName` TEXT NOT NULL, `password` TEXT NOT NULL, `designation` TEXT NOT NULL)");
        db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '123217367a819e1354344bddd4c1f66b')");
      }

      @Override
      public void dropAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS `reports`");
        db.execSQL("DROP TABLE IF EXISTS `attendance`");
        db.execSQL("DROP TABLE IF EXISTS `employees`");
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onDestructiveMigration(db);
          }
        }
      }

      @Override
      public void onCreate(@NonNull final SupportSQLiteDatabase db) {
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onCreate(db);
          }
        }
      }

      @Override
      public void onOpen(@NonNull final SupportSQLiteDatabase db) {
        mDatabase = db;
        internalInitInvalidationTracker(db);
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onOpen(db);
          }
        }
      }

      @Override
      public void onPreMigrate(@NonNull final SupportSQLiteDatabase db) {
        DBUtil.dropFtsSyncTriggers(db);
      }

      @Override
      public void onPostMigrate(@NonNull final SupportSQLiteDatabase db) {
      }

      @Override
      @NonNull
      public RoomOpenHelper.ValidationResult onValidateSchema(
          @NonNull final SupportSQLiteDatabase db) {
        final HashMap<String, TableInfo.Column> _columnsReports = new HashMap<String, TableInfo.Column>(7);
        _columnsReports.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsReports.put("employeeCode", new TableInfo.Column("employeeCode", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsReports.put("customerName", new TableInfo.Column("customerName", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsReports.put("reportDate", new TableInfo.Column("reportDate", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsReports.put("problem", new TableInfo.Column("problem", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsReports.put("status", new TableInfo.Column("status", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsReports.put("pdfPath", new TableInfo.Column("pdfPath", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysReports = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesReports = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoReports = new TableInfo("reports", _columnsReports, _foreignKeysReports, _indicesReports);
        final TableInfo _existingReports = TableInfo.read(db, "reports");
        if (!_infoReports.equals(_existingReports)) {
          return new RoomOpenHelper.ValidationResult(false, "reports(com.example.rapidtech.Report).\n"
                  + " Expected:\n" + _infoReports + "\n"
                  + " Found:\n" + _existingReports);
        }
        final HashMap<String, TableInfo.Column> _columnsAttendance = new HashMap<String, TableInfo.Column>(6);
        _columnsAttendance.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAttendance.put("employeeCode", new TableInfo.Column("employeeCode", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAttendance.put("employeeName", new TableInfo.Column("employeeName", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAttendance.put("date", new TableInfo.Column("date", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAttendance.put("checkIn", new TableInfo.Column("checkIn", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAttendance.put("checkOut", new TableInfo.Column("checkOut", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysAttendance = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesAttendance = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoAttendance = new TableInfo("attendance", _columnsAttendance, _foreignKeysAttendance, _indicesAttendance);
        final TableInfo _existingAttendance = TableInfo.read(db, "attendance");
        if (!_infoAttendance.equals(_existingAttendance)) {
          return new RoomOpenHelper.ValidationResult(false, "attendance(com.example.rapidtech.Attendance).\n"
                  + " Expected:\n" + _infoAttendance + "\n"
                  + " Found:\n" + _existingAttendance);
        }
        final HashMap<String, TableInfo.Column> _columnsEmployees = new HashMap<String, TableInfo.Column>(5);
        _columnsEmployees.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEmployees.put("employeeCode", new TableInfo.Column("employeeCode", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEmployees.put("employeeName", new TableInfo.Column("employeeName", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEmployees.put("password", new TableInfo.Column("password", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEmployees.put("designation", new TableInfo.Column("designation", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysEmployees = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesEmployees = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoEmployees = new TableInfo("employees", _columnsEmployees, _foreignKeysEmployees, _indicesEmployees);
        final TableInfo _existingEmployees = TableInfo.read(db, "employees");
        if (!_infoEmployees.equals(_existingEmployees)) {
          return new RoomOpenHelper.ValidationResult(false, "employees(com.example.rapidtech.Employee).\n"
                  + " Expected:\n" + _infoEmployees + "\n"
                  + " Found:\n" + _existingEmployees);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "123217367a819e1354344bddd4c1f66b", "aaa4180155f99ddad7b1a7bcbbcd0e5f");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(config.context).name(config.name).callback(_openCallback).build();
    final SupportSQLiteOpenHelper _helper = config.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  @NonNull
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    final HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "reports","attendance","employees");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `reports`");
      _db.execSQL("DELETE FROM `attendance`");
      _db.execSQL("DELETE FROM `employees`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  @NonNull
  protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
    final HashMap<Class<?>, List<Class<?>>> _typeConvertersMap = new HashMap<Class<?>, List<Class<?>>>();
    _typeConvertersMap.put(ReportDao.class, ReportDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(AttendanceDao.class, AttendanceDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(EmployeeDao.class, EmployeeDao_Impl.getRequiredConverters());
    return _typeConvertersMap;
  }

  @Override
  @NonNull
  public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
    final HashSet<Class<? extends AutoMigrationSpec>> _autoMigrationSpecsSet = new HashSet<Class<? extends AutoMigrationSpec>>();
    return _autoMigrationSpecsSet;
  }

  @Override
  @NonNull
  public List<Migration> getAutoMigrations(
      @NonNull final Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> autoMigrationSpecs) {
    final List<Migration> _autoMigrations = new ArrayList<Migration>();
    return _autoMigrations;
  }

  @Override
  public ReportDao reportDao() {
    if (_reportDao != null) {
      return _reportDao;
    } else {
      synchronized(this) {
        if(_reportDao == null) {
          _reportDao = new ReportDao_Impl(this);
        }
        return _reportDao;
      }
    }
  }

  @Override
  public AttendanceDao attendanceDao() {
    if (_attendanceDao != null) {
      return _attendanceDao;
    } else {
      synchronized(this) {
        if(_attendanceDao == null) {
          _attendanceDao = new AttendanceDao_Impl(this);
        }
        return _attendanceDao;
      }
    }
  }

  @Override
  public EmployeeDao employeeDao() {
    if (_employeeDao != null) {
      return _employeeDao;
    } else {
      synchronized(this) {
        if(_employeeDao == null) {
          _employeeDao = new EmployeeDao_Impl(this);
        }
        return _employeeDao;
      }
    }
  }
}
