package com.tvd12.app.repo;

import com.tvd12.app.entity.LeaderBoard;
import com.tvd12.ezydata.mongodb.EzyMongoRepository;
import com.tvd12.ezyfox.database.annotation.EzyRepository;

@EzyRepository
public interface LeaderBoardRepo
        extends EzyMongoRepository<LeaderBoard.Id, LeaderBoard> {
}
