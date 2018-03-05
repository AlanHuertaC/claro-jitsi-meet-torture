/*
 * Copyright @ 2015 Atlassian Pty Ltd
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jitsi.meet.test.mobile.base;

import org.jitsi.meet.test.base.*;
import org.jitsi.meet.test.mobile.*;
import org.openqa.selenium.*;

import java.util.*;

/**
 * Creates mobile participant.
 */
public class MobileParticipantFactory
    extends ParticipantFactory<MobileParticipantOptions>
{
    /**
     * The private constructor of the factory.
     *
     * @param config - A <tt>Properties</tt> instance holding configuration
     *               properties required to setup new participants.
     */
    public MobileParticipantFactory(Properties config)
    {
        super(config);
    }

    @Override
    public Participant<? extends WebDriver> createParticipant(
        String configPrefix,
        ParticipantOptions options)
    {
        MobileParticipantOptions mobileOptions
            = new MobileParticipantOptions();
        mobileOptions.load(config, configPrefix, options);

        MobileParticipantBuilder builder
            = MobileParticipantBuilder.createBuilder(
                config,
                configPrefix,
                mobileOptions.getParticipantType());

        return builder.startNewDriver();
    }
}