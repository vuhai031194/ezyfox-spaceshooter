package com.tvd12.app.repo;

import com.tvd12.app.entity.GamePlayerId;
import com.tvd12.app.entity.PlayerCurrentGame;
import com.tvd12.ezydata.mongodb.EzyMongoRepository;
import com.tvd12.ezyfox.database.annotation.EzyRepository;

@EzyRepository
public interface PlayerCurrentGameRepo
        extends EzyMongoRepository<GamePlayerId, PlayerCurrentGame> {
}
