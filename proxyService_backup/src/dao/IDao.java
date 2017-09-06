package dao;

import java.util.List;

import model.Channel;
import model.Mapping;
import model.PhysicalChannel;
import model.Picture;
import model.ScheduleRecord;

public interface IDao {
	public void registChannel(Channel c);
	public void updateChannel(Channel c);
	public void deleteChannel(Channel c);
	public void registMapping(Mapping m);
	public void deleteMapping(Mapping m);
	public void registPicture(Picture p);
	public void updatePicture(Picture p);
	public void deletePicture(Picture p);
	public void registScheduleRecord(ScheduleRecord sr);
	public void updateScheduleRecord(ScheduleRecord sr);
	public void deleteScheduleRecord(ScheduleRecord sr);
	public void registPhysicalChannel(PhysicalChannel pc);
	public void updatePhysicalChannel(PhysicalChannel pc);
	public void deletePhysicalChannel(PhysicalChannel pc);
	public void response(String CMSID, String SOPID, String correlateID, 
			int resultCode, String errorDescription, String resultFileURL);
}
