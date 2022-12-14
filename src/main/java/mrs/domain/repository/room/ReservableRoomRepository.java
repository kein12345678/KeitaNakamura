package mrs.domain.repository.room;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.LockModeType;

import mrs.domain.model.ReservableRoom;
import mrs.domain.model.ReservableRoomId;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ReservableRoomRepository extends JpaRepository<ReservableRoom, ReservableRoomId>{
	// 鈴木さんより引用（削除）
	List<ReservableRoom> findByReservableRoomId_reservedDateOrderByReservableRoomId_roomIdAsc(LocalDate reservedDate);
	
	@Lock(LockModeType.PESSIMISTIC_WRITE)
	ReservableRoom findOneForUpdateByReservableRoomId(ReservableRoomId reservableRoomId);
}
