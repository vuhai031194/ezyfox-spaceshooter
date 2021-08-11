package com.tvd12.app.repo;

import com.tvd12.app.entity.GameCurrentState;
import com.tvd12.app.entity.GameId;
import com.tvd12.ezydata.mongodb.EzyMongoRepository;
import com.tvd12.ezyfox.database.annotation.EzyRepository;

@EzyRepository
public interface GameCurrentStateRepo
        extends EzyMongoRepository<GameId, GameCurrentState> {
}
