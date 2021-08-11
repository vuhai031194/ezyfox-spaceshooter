package com.tvd12.plugin.repo;

import com.tvd12.ezydata.mongodb.EzyMongoRepository;
import com.tvd12.ezyfox.database.annotation.EzyRepository;
import com.tvd12.plugin.entity.Credential;
import com.tvd12.plugin.entity.GamePlayerId;

@EzyRepository
public interface CredentialRepo
        extends EzyMongoRepository<GamePlayerId, Credential> {
}
