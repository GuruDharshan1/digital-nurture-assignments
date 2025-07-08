package com.cts.service;

import com.cts.model.Attempt;

public interface AttemptService {
    Attempt getAttempt(int userId, int attemptId);
}
