package dao;

import java.util.List;
import model.Record;
import model.Staff;

public interface RecordDao {
	List<Record> getAllRecords();
	List<Record> getAllRecords(boolean type);
	List<Record> getRecordsOfStaff(Staff staff);
	Record getRecordById(int recordId);
	void saveRecord(Record record);
	void updateRecord(Record record);
	void deleteRecord(Record record);
}
